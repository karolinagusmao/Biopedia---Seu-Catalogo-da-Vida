package com.karol.biopedia.Activity;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.karol.biopedia.DAO.ConfiguracaoFirebase;
import com.karol.biopedia.Entidades.Usuarios;
import com.karol.biopedia.Helper.Base64Custom;
import com.karol.biopedia.Helper.Preferencias;
import com.karol.biopedia.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class CadastroActivity extends AppCompatActivity {

    //inicia objetos
    private EditText editCadEmail;
    private EditText editCadNome;
    private EditText editCadSenha;
    private EditText editCadConfirmaSenha;
    private EditText editCadDtNasc;
    private EditText editCadCidade;
    private EditText editCadEstado;
    private RadioButton rbMasculino;
    private RadioButton rbFeminino;
    private Button btnCadastrar;
    private Usuarios usuarios;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //captura objetos
        editCadEmail = (EditText) findViewById(R.id.editCadEmail);
        editCadNome = (EditText) findViewById(R.id.editCadNome);
        editCadSenha = (EditText) findViewById(R.id.editCadSenha);
        editCadConfirmaSenha = (EditText) findViewById(R.id.editCadConfirmaSenha);
        editCadDtNasc = (EditText) findViewById(R.id.editCadDtNasc);
        editCadEstado = (EditText) findViewById(R.id.editCadEstado);
        editCadCidade = (EditText) findViewById(R.id.editCadCidade);
        rbFeminino = (RadioButton) findViewById(R.id.rbFeminino);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editCadSenha.getText().toString().equals(editCadConfirmaSenha.getText().toString())){

                    usuarios = new Usuarios();
                    usuarios.setNome(editCadNome.getText().toString());
                    usuarios.setEmail(editCadEmail.getText().toString());
                    usuarios.setSenha(editCadSenha.getText().toString());
                    usuarios.setDtNasc(editCadDtNasc.getText().toString());
                    usuarios.setEstado(editCadEstado.getText().toString());
                    usuarios.setCidade(editCadCidade.getText().toString());

                    if (rbFeminino.isChecked()) {
                        usuarios.setSexo("Feminino");
                    } else {
                        usuarios.setSexo("Masculino");
                    }

                    cadastrarUsuario();

                }else {
                    Toast.makeText(CadastroActivity.this, "As senhas não são correspondentes", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void cadastrarUsuario (){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuarios.getEmail(),
                usuarios.getSenha()
        ).addOnCompleteListener(CadastroActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(CadastroActivity.this, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show();

                    String identificadorUsuario = Base64Custom.codificarBase64(usuarios.getEmail());
                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    usuarios.setId(identificadorUsuario);
                    usuarios.cadastrar();

                    Preferencias preferencias = new Preferencias(CadastroActivity.this);
                    preferencias.salvarUsuarioPreferencias(identificadorUsuario, usuarios.getNome());

                    abrirLoginUsuario();
                } else {
                    String erroExcecao = "";

                    try{
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        erroExcecao = "Digite uma senha mais forte, contendo no mínimo 8 caracteres de letras e números";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erroExcecao = "O e-mail digitado é inválido, digite um novo e-mail válido";
                    }catch (FirebaseAuthUserCollisionException e){
                        erroExcecao = "Esse e-mail já está cadastrado no sistema";
                    }catch (Exception e){
                        erroExcecao = "Erro ao efetuar o cadastro!";
                        e.printStackTrace();
                    }
                    Toast.makeText(CadastroActivity.this, "Erro: " + erroExcecao, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void abrirLoginUsuario(){
        Intent intent = new Intent( CadastroActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
