package com.dicoding.picodiploma.finalsubmission;import android.database.Cursor;import android.os.Bundle;import androidx.appcompat.app.AppCompatActivity;import androidx.fragment.app.Fragment;import com.dicoding.picodiploma.finalsubmission.fragments.FavoriteFragment;import com.dicoding.picodiploma.finalsubmission.fragments.moviefragments.MovieFragment;import com.dicoding.picodiploma.finalsubmission.fragments.tvshowfragments.TvShowFragment;import com.google.android.material.bottomnavigation.BottomNavigationView;import butterknife.ButterKnife;public class MainActivity extends AppCompatActivity implements LoadCallback {    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener            = item -> {        Fragment fragment;        // statement dibawah ini berguna untuk memilih dan menampilkan fragement di main activity        switch (item.getItemId()) {            case R.id.navigation_movie:                fragment = new MovieFragment();                getSupportFragmentManager().beginTransaction().replace(R.id.container_layout,                        fragment, fragment.getClass().getSimpleName()).commit();                return true;            case R.id.navigation_tvshow:                fragment = new TvShowFragment();                getSupportFragmentManager().beginTransaction().replace(R.id.container_layout,                        fragment, fragment.getClass().getSimpleName()).commit();                return true;            case R.id.navigation_favorite:                fragment = new FavoriteFragment();                getSupportFragmentManager().beginTransaction().replace(R.id.container_layout,                        fragment, fragment.getClass().getSimpleName()).detach(fragment).attach(fragment).commit();                return true;        }        return false;    };    @Override    protected void onCreate(Bundle savedInstanceState) {        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_main);        ButterKnife.bind(this);        BottomNavigationView navView = findViewById(R.id.nav_view);        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);        if (savedInstanceState == null) {            navView.setSelectedItemId(R.id.navigation_movie);        }        if (getSupportActionBar() != null) {            getSupportActionBar().setTitle(getString(R.string.dicoding_movie));        }    }    @Override    public void preExecute() {    }    @Override    public void postExecute(Cursor cursor) {    }}