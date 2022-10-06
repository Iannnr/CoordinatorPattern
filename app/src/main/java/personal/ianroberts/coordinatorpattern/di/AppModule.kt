package personal.ianroberts.coordinatorpattern.di

import android.app.Activity
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import personal.ianroberts.coordinatorpattern.navigation.FeatureNavigator
import personal.ianroberts.coordinatorpattern.navigation.FlowNavigator

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {

    @Provides
    @FragmentScoped
    fun provideNavigator(fragment: Fragment): FlowNavigator {
        return fragment as FlowNavigator
    }
}

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    @ActivityScoped
    fun provideFeatureNavigator(activity: Activity): FeatureNavigator {
        return activity as FeatureNavigator
    }
}