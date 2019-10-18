package nandaadi.saputra.fragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import nandaadi.saputra.fragment.fragment.FragmentDua
import nandaadi.saputra.fragment.fragment.FragmentSatu
import nandaadi.saputra.fragment.fragment.FragmentTiga

class TabAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val pages = listOf(
        FragmentSatu(),
        FragmentDua(),
        FragmentTiga()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "CHAT"
            1 -> "STATUS"
            else -> "PANGGILAN"
        }
    }

}