package com.example.departmentactivity

import android.content.Context
import android.provider.SyncStateContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.departmentactivity.models.Department
import kotlinx.android.synthetic.main.layout_department_list_item.view.*


class DepartmentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    private var items: List<Department> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DepartmentViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_department_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is DepartmentViewHolder -> {
                holder.bind(items[position])
            }

        }
    }

    fun submitList(DepartmentList: List<Department>){
        items = DepartmentList
    }

    class DepartmentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val department_image = itemView.department_image
        val department_title = itemView.title
        val department_price = itemView.price
        val department_time = itemView.time

        fun bind(departmentPost: Department){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
            val image = departmentPost.image
            val imageInt: Int = itemView.context.resources.getIdentifier(
                image,
                "drawable",
                itemView.context.packageName
            )

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(imageInt)
                .into(department_image)

            department_title.text = departmentPost.title
            department_price.text = departmentPost.price
            department_time.text = departmentPost.time

        }

    }



}
