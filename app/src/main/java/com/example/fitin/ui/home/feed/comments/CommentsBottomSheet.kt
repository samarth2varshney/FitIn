package com.example.fitin.ui.home.feed.comments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.example.fitin.data.remote.CommentItem
import com.example.fitin.databinding.FragmentCommentsBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CommentsBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentCommentsBottomSheetBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener {

            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let {
                val behaviour = BottomSheetBehavior.from(it)
                val layoutParams = it.layoutParams
                layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
                it.layoutParams = layoutParams
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCommentsBottomSheetBinding.inflate(inflater,container,false)

        val controller = CommentsEpoxyController()

        binding.epoxyRecyclerView.post {
            binding.epoxyRecyclerView.setController(controller)
        }

        controller.setData(listOf(
            CommentItem(1,"yahooo how are you","kartik","24"),
            CommentItem(2,"wohooo life is enjoying","samarth","50"),
            CommentItem(3,"yahooo how are you","kartik","24"),
            CommentItem(4,"wohooo life is enjoying","samarth","50"),
            CommentItem(5,"yahooo how are you","kartik","24"),
            CommentItem(6,"yahooo how are you","kartik","24"),
            CommentItem(7,"wohooo life is enjoying","samarth","50"),
            CommentItem(8,"yahooo how are you","kartik","24"),
            CommentItem(9,"wohooo life is enjoying","samarth","50"),
            CommentItem(1,"yahooo how are you","kartik","24"),
            CommentItem(2,"wohooo life is enjoying","samarth","50"),
            CommentItem(3,"yahooo how are you","kartik","24"),
            CommentItem(4,"wohooo life is enjoying","samarth","50"),
            CommentItem(5,"yahooo how are you","kartik","24"),
            CommentItem(6,"yahooo how are you","kartik","24"),
            CommentItem(7,"wohooo life is enjoying","samarth","50"),
            CommentItem(8,"yahooo how are you","kartik","24"),
            CommentItem(9,"wohooo life is enjoying","samarth","50"),
        ))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}