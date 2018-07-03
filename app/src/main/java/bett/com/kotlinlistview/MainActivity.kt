package bett.com.kotlinlistview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import bett.com.kotlinlistview.adapters.UserListAdapter
import bett.com.kotlinlistview.dtos.UserDto

class MainActivity: AppCompatActivity(), View.OnClickListener, UserListAdapter.onItemClickListener {

    override fun onItemClick() {
        val intent = Intent(this,DetailActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var listView: ListView? = null
    var adapter: UserListAdapter? = null

    var add :Int = 0 ;
    var sub :Long = 0 ;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById<ListView>(R.id.listView)
        adapter = UserListAdapter(this, generateData(),this)

        listView?.adapter = adapter
        adapter?.notifyDataSetChanged()

        val a = 5
        val b = 10
        add = a+b;
        sub = (a*b).toLong();
        Log.i("Add value ",""+add)
        Log.i("Sub",""+sub)

        for(a in a..b){
            Log.i("for loop :  ",""+a)
        }

        for (i in b downTo 0 step 3) {
            Log.i("for loop down :  ",""+i)
        }

    }

    fun generateData(): ArrayList<UserDto> {
        var result = ArrayList<UserDto>()

        for (i in 0..9) {
            var user: UserDto = UserDto("Bett", "Awesome work ;)")
            result.add(user)
        }

        return result
    }
}
