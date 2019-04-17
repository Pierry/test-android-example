package com.github.pierry.test.form.presentation.view

import com.github.pierry.test.core.presentation.BaseView

interface FormView : BaseView {

  fun getFormLayout(): FormLayout
  fun clearForm()
  fun isFormError(): Boolean
  fun showFormErrors()
  fun hideFormErrors()
  fun showSuccessView()
  fun hideSuccessView()
  fun setFormLayoutListeners()

}