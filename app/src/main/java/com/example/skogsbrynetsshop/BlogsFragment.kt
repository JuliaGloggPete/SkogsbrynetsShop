import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skogbrynetsverkstad.data.Blog
import com.example.skogbrynetsverkstad.data.Product
import com.example.skogsbrynetsshop.R
import com.example.skogsbrynetsshop.RecycleAdapter.BlogRecycleAdapter
import com.example.skogsbrynetsshop.db
import com.google.firebase.firestore.toObject


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlogsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlogsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    val blogList = mutableListOf<Blog>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blogs, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.blogRecyclerview)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = BlogRecycleAdapter( requireContext(), blogList)
        recyclerView.adapter = adapter


        val docRef = db.collection("Blog")
        docRef.get().addOnSuccessListener { collectionSnapShot ->
            for (document in collectionSnapShot.documents) {
                val item = document.toObject<Blog>()
                if (item != null) {
                    blogList.add(item)
                }
            }
            adapter.notifyDataSetChanged()
        }

        return view

    }






    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlogsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlogsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
