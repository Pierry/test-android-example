package com.github.pierry.test.form.presentation.domain.cell

import com.github.pierry.test.form.domain.Type
import com.github.pierry.test.form.domain.cell.Cell
import com.github.pierry.test.form.domain.cell.FieldCell
import com.github.pierry.test.form.presentation.domain.cell.base.CellView
import com.github.pierry.test.form.presentation.view.FormLayout

class FormViewBuilder(private val rootView: FormLayout) {

  fun proccessCellsFormView(cells: MutableList<Cell>): MutableList<CellView> {
    val listCellView = mutableListOf<CellView>()
    cells.forEach { cell ->
      listCellView.add(getCellView(cell))
    }
    rootView.setCellsView(listCellView)
    return listCellView
  }

  private fun getCellView(cell: Cell): CellView {
    return when (cell.type) {
      Type.FIELD -> TextFieldCellView(cell as FieldCell, rootView)
      Type.TEXT -> TextCellView(cell, rootView)
      Type.CHECKBOX -> CheckboxCellView(cell, rootView)
      Type.SEND -> SendCellView(cell, rootView)
      else -> TextCellView(cell, rootView)
    }
  }

}