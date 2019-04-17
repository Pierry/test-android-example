package com.github.pierry.test.form.presentation.domain.cell

import android.view.ViewGroup
import android.widget.TextView
import com.github.pierry.test.R
import com.github.pierry.test.form.domain.cell.Cell
import com.github.pierry.test.form.presentation.domain.cell.base.CellView

class TextCellView(
        private val textCell: Cell,
        private val rootView: ViewGroup
) : CellView(textCell, rootView) {

  init {
    inflateView()
  }

  override fun inflateView() {
    inflateLayout(R.layout.text_cell_view)
    (this.view as TextView).text = textCell.message
  }

}