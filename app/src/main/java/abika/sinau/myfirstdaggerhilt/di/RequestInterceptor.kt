package abika.sinau.myfirstdaggerhilt.di

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


/**
 * @author by Abika Chairul Yusri on 5/26/2022
 */
class RequestInterceptor @Inject constructor(
    private val token: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val request = original.newBuilder()
            .header("Token", token)
            .build()

        return chain.proceed(request)
    }
}