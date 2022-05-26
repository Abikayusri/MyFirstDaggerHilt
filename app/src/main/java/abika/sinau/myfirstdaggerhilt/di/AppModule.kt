package abika.sinau.myfirstdaggerhilt.di

import abika.sinau.myfirstdaggerhilt.MyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * @author by Abika Chairul Yusri on 5/26/2022
 */

// TODO 4: Create new class module, and add some module for inject
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://google.com"

    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient): MyApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
            .create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        interceptor: RequestInterceptor // Interceptor use for handle any request
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor) // this syntax use for add interceptor (sunnah!)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }
}