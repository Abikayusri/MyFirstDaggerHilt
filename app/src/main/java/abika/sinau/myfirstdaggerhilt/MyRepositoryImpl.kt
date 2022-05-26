package abika.sinau.myfirstdaggerhilt

import javax.inject.Inject


/**
 * @author by Abika Chairul Yusri on 5/26/2022
 */
// TODO: Add annotation @Inject if we want inject the constructor
class MyRepositoryImpl @Inject constructor(
    private val api: MyApi
) : MyRepository {

    override fun doNetworkCall() {
        api.callApi()
    }
}