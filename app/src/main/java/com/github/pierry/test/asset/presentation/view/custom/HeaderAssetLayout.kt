package com.github.pierry.test.asset.presentation.view.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.github.pierry.test.R
import com.github.pierry.test.asset.presentation.model.HeaderInfos
import kotlinx.android.synthetic.main.header_asset.view.*

class HeaderAssetLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

  init {
    LayoutInflater.from(context).inflate(R.layout.header_asset, this)
  }

  fun setInfos(headerInfos: HeaderInfos) {
    textViewAssetName.text = headerInfos.assetName
    textViewHeaderTitle.text = headerInfos.title
    textViewHeaderWhatIs.text = headerInfos.whatIs
    textViewHeaderDefinition.text = headerInfos.definition
  }

}