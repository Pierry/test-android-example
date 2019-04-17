package com.github.pierry.test.form.presentation.domain.cell.base

import android.view.ViewGroup
import com.github.pierry.test.form.domain.cell.FieldCell

abstract class FieldCellView(
        val fieldCell: FieldCell,
        private val rootView: ViewGroup) : CellView(fieldCell, rootView
) {

  abstract fun isValidAnswer(): Boolean
  abstract fun showError()
  abstract fun hideError()
  abstract fun clearField()

}