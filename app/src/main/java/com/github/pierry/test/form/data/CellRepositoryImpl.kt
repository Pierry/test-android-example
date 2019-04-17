package com.github.pierry.test.form.data

import com.github.pierry.test.core.data.FloatingMountainApi
import com.github.pierry.test.form.domain.CellRepository
import com.github.pierry.test.form.domain.cell.Cell
import io.reactivex.Flowable

class CellRepositoryImpl(
        private val floatingMountainApi: FloatingMountainApi
) : CellRepository {

  override fun getCells(): Flowable<MutableList<Cell>> {
    return floatingMountainApi.getCells()
            .flatMap { response ->
              if (response.isSuccessful) {
                Flowable.just(response.body())
              } else {
                Flowable.empty()
              }
            }
            .map(CellMapper::map)
  }
}