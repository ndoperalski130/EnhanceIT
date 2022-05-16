package com.example.noahdoperalskiitunes.controller

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.noahdoperalskiitunes.MusicFragment
import com.example.noahdoperalskiitunes.MusicFragment2
import com.example.noahdoperalskiitunes.MusicFragment3


class MusicTabAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position)
        {
            0 ->
            {
                val frag = MusicFragment()
                return frag
            }
            1 ->
            {
                val frag = MusicFragment2()
                return frag
            }
            2 ->
            {
                val frag = MusicFragment3()
                return frag
            }
            else -> return MusicFragment()
        }
    }

}