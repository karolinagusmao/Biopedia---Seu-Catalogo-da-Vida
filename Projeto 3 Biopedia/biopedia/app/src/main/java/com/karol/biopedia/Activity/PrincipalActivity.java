package com.karol.biopedia.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.google.firebase.auth.FirebaseAuth;
import com.karol.biopedia.DAO.ConfiguracaoFirebase;
import com.karol.biopedia.R;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth usuarioFirebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        usuarioFirebase = ConfiguracaoFirebase.getFirebaseAutenticacao();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sair) {
            deslogarUsuario();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent home = new Intent(getApplicationContext(), PrincipalActivity.class);
            startActivity(home);
            return true;
        } else if (id == R.id.nav_fauna) {
            Intent fauna = new Intent(getApplicationContext(), InicioFauna.class);
            startActivity(fauna);
            return true;
        } else if (id == R.id.nav_flora) {
            Intent flora = new Intent(getApplicationContext(), InicioFlora.class);
            startActivity(flora);
            return true;
        } else if (id == R.id.nav_editPerfil) {
            Intent perfil = new Intent(getApplicationContext(), Perfil.class);
            startActivity(perfil);
            return true;
        } else if (id == R.id.nav_dtAmbientais){
            Intent datas = new Intent(getApplicationContext(), DatasImportantes.class);
            startActivity(datas);
            return true;
        } else if (id == R.id.nav_sobre) {
            Intent compartilhe = new Intent(getApplicationContext(), SobreBiopedia.class);
            startActivity(compartilhe);
            return true;
        }else if (id == R.id.nav_updates) {
            Intent atualizacao = new Intent(getApplicationContext(), Atualizacoes.class);
            startActivity(atualizacao);
            return true;
        }

        //fecha o menu toda vez que for clicado
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void deslogarUsuario() {
        usuarioFirebase.signOut();
        Intent intent = new Intent(PrincipalActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
