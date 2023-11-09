package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding
    lateinit var adapter: RecipeAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<Recipe>()
        list.add(Recipe("Oppenheimer", "Christopher Nolan", "2023", "USA"))
        list.add(Recipe("Zodiac", "David Fincher", "2007", "USA"))
        list.add(Recipe("Interstellar", "Christopher Nolan", "2014", "USA"))
        list.add(Recipe("Snatch", "Guy Ritchie", "2000", "USA"))
        list.add(Recipe("Pulp Fiction", "Quentin Tarantino", "1994", "USA"))

        adapter = RecipeAdapter() { recipe, position ->
            findNavController().navigate(
                FirstFragmentDirections.toSecondFragment(
                    recipe.name,
                    recipe.author,
                    recipe.year,
                    recipe.country
                )
            )
            Toast.makeText(requireContext(), "Clicked element №$position", Toast.LENGTH_SHORT)
                .show()
        }
        adapter.setList(list)
        binding.rv.adapter = adapter

        binding.firstBtnToSecond.setOnClickListener {

            findNavController().navigate(
                FirstFragmentDirections.toSecondFragment(
                    "Name",
                    "Author",
                    "Year",
                    "Country"
                )
            )
        }
    }
}