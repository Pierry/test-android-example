package com.github.pierry.test.form.presentation.domain.cell

import android.view.ViewGroup
import android.widget.CheckBox
import com.github.pierry.test.R
import com.github.pierry.test.form.domain.cell.Cell
import com.github.pierry.test.form.presentation.domain.cell.base.CellView

class CheckboxCellView(
        private val checkboxCell: Cell,
        private val rootView: ViewGroup
) : CellView(checkboxCell, rootView) {

  init {
    this.inflateView()
  }

  override fun inflateView() {
    inflateLayout(R.layout.checkbox_cell_view)
    (this.view as CheckBox).text = checkboxCell.message
    (this.view as CheckBox).setOnCheckedChangeListener { _, checked ->
      if (checked) {
        onShowViewRequest?.showView(checkboxCell.show)
      } else {
        onShowViewRequest?.hideView(checkboxCell.show)
      }
    }
  }

}