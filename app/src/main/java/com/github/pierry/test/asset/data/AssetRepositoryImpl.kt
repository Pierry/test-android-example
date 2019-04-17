package com.github.pierry.test.asset.data

import com.github.pierry.test.asset.data.entity.AssetJsonResponse
import com.google.gson.Gson
import com.github.pierry.test.asset.domain.AssetRepository
import com.github.pierry.test.asset.domain.entity.Asset
import com.github.pierry.test.core.data.FloatingMountainApi
import io.reactivex.Flowable

class AssetRepositoryImpl(
        private val floatingMountainApi: FloatingMountainApi,
        private val gson: Gson
) : AssetRepository {

  override fun getAsset(): Flowable<Asset> {
    return floatingMountainApi.getAsset()
            .flatMap { response ->
              val responseFix = removeWrongCommas(response.string())
              Flowable.just(responseFix)
            }
            .flatMap { response ->
              Flowable.just(convert(response))
            }
            .map(AssetMapper::map)
  }

  private fun removeWrongCommas(response: String): String {
    return response.replace(",      }", "}")
            .replace("\n", "")
            .replace("\t", "")
            .replace(" \"", "\"")
            .replace("\" ", "\"")
            .replace("\",}", "\"}")
            .replace("\",    }", "\"}")
  }

  private fun convert(string: String): AssetJsonResponse =
          gson.fromJson(string, AssetJsonResponse::class.java)
}