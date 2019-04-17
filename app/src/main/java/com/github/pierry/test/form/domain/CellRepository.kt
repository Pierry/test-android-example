package com.github.pierry.test.form.domain

import com.github.pierry.test.form.domain.cell.Cell
import io.reactivex.Flowable

interface CellRepository {

  fun getCells(): Flowable<MutableList<Cell>>

}