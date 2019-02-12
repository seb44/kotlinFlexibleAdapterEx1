package fr.sebastienlaunay.kotlinflexibleadapterex1

import eu.davidea.flexibleadapter.items.AbstractFlexibleItem
import fr.sebastienlaunay.kotlinflexibleadapterex1.Model.Order
import fr.sebastienlaunay.tanexpress.ui.AbsFlexibleAdapter
import fr.sebastienlaunay.tanexpress.ui.AbsFlexibleViewHolder

class OrderFlexibleAdapter(orderList: List<Order>, private val listener: OrderListener) :
    AbsFlexibleAdapter<AbstractFlexibleItem<AbsFlexibleViewHolder>, AbsFlexibleViewHolder>() {

    var orderList = orderList

    fun updateData() {
        setData(orderList)
    }

    fun setData(orderList: List<Order>) {
        val dataToDisplay = mutableListOf<AbstractFlexibleItem<AbsFlexibleViewHolder>>()

        orderList.forEach { order ->
            dataToDisplay.add(OrderFlexibleItem(order, listener))
        }

        updateDataSet(dataToDisplay)
    }

    interface OrderListener {
        fun onOrderClicked(orderId: Int)
    }
}