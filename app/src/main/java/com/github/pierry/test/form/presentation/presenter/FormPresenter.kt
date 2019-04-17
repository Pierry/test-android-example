package com.github.pierry.test.form.presentation.presenter

import com.github.pierry.test.core.presentation.BasePresenter

interface FormPresenter : BasePresenter {

  fun onSendEventClicked()
  fun onSendNewMessageClicked()

}