package com.github.pierry.test.form.presentation.domain.cell

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.github.pierry.test.R
import com.github.pierry.test.form.domain.cell.Cell
import com.github.pierry.test.form.presentation.domain.cell.base.CellView

class SendCellView(
        private val sendFieldCell: Cell,
        private val rootView: ViewGroup
) : CellView(sendFieldCell, rootView) {

  init {
    this.inflateView()
  }

  override fun inflateView() {
    inflateLayout(R.layout.send_cell_view)
    (this.view as Button).text = sendFieldCell.message
  }

  fun setSendListener(clickListener: View.OnClickListener) {
    this.view.setOnClickListener(clickListener)
  }

}