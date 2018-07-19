package com.example.fredericomonteiro.githubtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    GitHubUserProfile userInfo = new GitHubUserProfile();
    String user;
    Button button;
    EditText edittext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button1);
        edittext=findViewById(R.id.editText1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                user = edittext.getText().toString();

                Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl("https://api.github.com/")
                        .addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofit = builder.build();

                GitHubClient client = retrofit.create(GitHubClient.class);

                Call<GitHubUserProfile> call = client.infoForUser(user);
                call.enqueue(new Callback<GitHubUserProfile>() {
                    @Override
                    public void onResponse(Call<GitHubUserProfile> call, Response<GitHubUserProfile> response) {

                        GitHubUserProfile userProfile = new GitHubUserProfile();
                        assert response.body() != null;
                        // fazer verificação se user encontrado continua else um toast a dizer que user n foi encontrado
                        // não foi implementado por ser facil de fazer e n tenho tempo chego a casa as 19:30 xD
                        // acrescentar mais uma prop a class e verificar se a message != null entao user n encontrado
                        // se o user for encontrado entao fazer o pedido tbm da lista de repos e followers ver class GitHubRepoAdapter necessaria para a lista

                        userProfile.setName(response.body().getName());
                        userProfile.setBio(response.body().getBio());
                        userProfile.setEmail(response.body().getEmail());
                        userProfile.setAvatar_url(response.body().getAvatar_url());
                        userInfo = userProfile;


                        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                        intent.putExtra("user info", userInfo);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<GitHubUserProfile> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Ups! something went wrong.", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });




       //Call<List<GitHubRepo>> call = client.reposForUser("fs-opensource");

       /*call.enqueue(new Callback<List<GitHubRepo>>() {
           @Override
           public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
               List<GitHubRepo> repos = response.body();


              listView.setAdapter(new GitHubRepoAdapter(MainActivity.this, repos));
           }

           @Override
           public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
               Toast.makeText(MainActivity.this, "Ups!!!", Toast.LENGTH_SHORT).show();
           }
       });*/




    }


}
