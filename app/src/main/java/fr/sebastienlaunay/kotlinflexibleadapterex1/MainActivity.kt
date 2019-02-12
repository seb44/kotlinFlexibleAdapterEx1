package fr.sebastienlaunay.kotlinflexibleadapterex1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import fr.sebastienlaunay.kotlinflexibleadapterex1.Model.Order
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OrderFlexibleAdapter.OrderListener {

    private var orderList = ArrayList<Order>()

    private lateinit var orderListAdapter: OrderFlexibleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        orderListAdapter = OrderFlexibleAdapter(orderList, this)

        laListe.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = orderListAdapter
        }

        val order1 = Order(1, "Titre 1", "Sous titre 1", false)
        val order2 = Order(2, "Titre 2", "Sous titre 2", false)
        val order3 = Order(3, "Titre 3", "Sous titre 3", true)
        val order4 = Order(4, "Titre 4", "Sous titre 4", false)
        val order5 = Order(5, "Titre 4", "Sous titre 5", true)
        val order6 = Order(6, "Titre 6", "Sous titre 6", false)
        val order7 = Order(7, "Titre 7", "Sous titre 7", false)
        val order8 = Order(8, "Titre 8", "Sous titre 8", false)
        val order9 = Order(9, "Titre 9", "Sous titre 9", false)
        val order10 = Order(10, "Titre 10", "Sous titre 10", false)
        val order11 = Order(11, "Titre 11", "Sous titre 11", false)
        val order12 = Order(12, "Titre 12", "Sous titre 12", false)
        val order13 = Order(13, "Titre 13", "Sous titre 13", true)
        val order14 = Order(14, "Titre 14", "Sous titre 14", false)
        val order15 = Order(15, "Titre 14", "Sous titre 15", true)
        val order16 = Order(16, "Titre 16", "Sous titre 16", false)
        val order17 = Order(17, "Titre 17", "Sous titre 17", false)
        val order18 = Order(18, "Titre 18", "Sous titre 18", false)
        val order19 = Order(19, "Titre 19", "Sous titre 19", false)
        val order20 = Order(20, "Titre 20", "Sous titre 20", false)

        orderList.add(order1)
        orderList.add(order2)
        orderList.add(order3)
        orderList.add(order4)
        orderList.add(order5)
        orderList.add(order6)
        orderList.add(order7)
        orderList.add(order8)
        orderList.add(order9)
        orderList.add(order10)
        orderList.add(order11)
        orderList.add(order12)
        orderList.add(order13)
        orderList.add(order14)
        orderList.add(order15)
        orderList.add(order16)
        orderList.add(order17)
        orderList.add(order18)
        orderList.add(order19)
        orderList.add(order20)

        orderList.let {
            orderListAdapter.setData(it)
        }

        btnValidate.setOnClickListener {
            afficherLeResultat(orderList)
        }
    }

    private fun afficherLeResultat(orderList: ArrayList<Order>) {

        textResult.text = "Vous avez cliqué sur : "
        orderList.filter { it.validate == true }.apply {

            this.forEach {
                textResult.text = textResult.text.toString() + "${it.id} - "
            }
        }
    }

    override fun onOrderClicked(orderId: Int) {
        orderList.find { it.id == orderId }?.apply {
            this.validate = !this.validate
        }

        orderListAdapter.updateData()
    }


}

