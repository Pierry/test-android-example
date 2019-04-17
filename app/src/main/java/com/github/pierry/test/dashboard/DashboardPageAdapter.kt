package com.github.pierry.test.dashboard

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.github.pierry.test.asset.presentation.view.AssetFragment
import com.github.pierry.test.form.presentation.view.FormFragment

class DashboardPageAdapter(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager) {

  override fun getItem(position: Int): Fragment {
    return when (position) {
      0 -> AssetFragment()
      1 -> FormFragment()
      else -> FormFragment()
    }
  }

  override fun getCount(): Int {
    return 2
  }

  override fun getPageTitle(position: Int): CharSequence? {
    return when (position) {
      0 -> "Investmento"
      1 -> "Contato"
      else -> ""
    }
  }
}