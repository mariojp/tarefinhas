package br.com.mariojp.mobile.applicationbes.view.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import br.com.mariojp.mobile.applicationbes.Repository;

public class TarefaViewModelFabrica implements ViewModelProvider.Factory {

    private Repository repository;

    public TarefaViewModelFabrica(Repository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new TarefaViewModel(repository);
    }
}
