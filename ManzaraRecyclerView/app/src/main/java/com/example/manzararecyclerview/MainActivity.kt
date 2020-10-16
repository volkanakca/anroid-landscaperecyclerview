package com.example.manzararecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var tumManzaralar=ArrayList<Manzara>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        veriKaynaginiDoldur()
        var myAdapter=ManzaraAdapter(tumManzaralar)
        recyclerViewManzara.adapter=myAdapter
        var linearLayoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerViewManzara.layoutManager=linearLayoutManager

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.anamenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id=item.itemId
        when(id){
            R.id.menuLinearViewHorizontal->{var linearLayoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
                recyclerViewManzara.layoutManager=linearLayoutManager}
            R.id.menuLinearViewVertical->{var menuLinearViewVertical=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                recyclerViewManzara.layoutManager=menuLinearViewVertical}
            R.id.menuGrid->{var menuGrid=GridLayoutManager(this,2)
                recyclerViewManzara.layoutManager=menuGrid}
            R.id.menuStaggeredHorizontal->{
                var menuStaggeredHorizontal=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
                recyclerViewManzara.layoutManager=menuStaggeredHorizontal
            }
            R.id.menuStaggeredVertical->{var menuStaggeredVertical=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                recyclerViewManzara.layoutManager=menuStaggeredVertical

            }

        }
        return super.onOptionsItemSelected(item)
    }
    fun veriKaynaginiDoldur():ArrayList<Manzara>{
     var tumResimler=arrayOf(R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,
         R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,
         R.drawable.img11,R.drawable.img12,R.drawable.img13,R.drawable.img14,R.drawable.img5,
         R.drawable.img16,R.drawable.img17,R.drawable.img18,R.drawable.img19,R.drawable.img20,)
        for(i in 0..tumResimler.size-1){
            var eklenecekManzara=Manzara("manzara"+i,"Açıklama"+i,tumResimler[i])
            tumManzaralar.add(eklenecekManzara)
        }
        return tumManzaralar
    }
}