package com.example.manzararecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tek_satir_manzara.view.*

class ManzaraAdapter(tumManzaralar:ArrayList<Manzara>): RecyclerView.Adapter<ManzaraAdapter.ManzaraViwHolder>() {
    var manzaralar=tumManzaralar
   inner class ManzaraViwHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var teksatirManzara=itemView as CardView
        var manzaraBaslik=teksatirManzara.tvManzaraBaslik
        var manzaraAciklama=teksatirManzara.tvManzaraAcıklama
        var manzaraResim=teksatirManzara.imgManzara
        var btnKopyala=teksatirManzara.imgKopyala
        var btnSil=teksatirManzara.imgSil
        init {

        }
        fun setData(oankiManzara:Manzara,position: Int){
           manzaraBaslik.text=oankiManzara.baslik
            manzaraAciklama.text=oankiManzara.aciklama
            manzaraResim.setImageResource(oankiManzara.resim)

            btnKopyala.setOnClickListener {
                manzaralar.add(position,oankiManzara)
                notifyItemInserted(position)
                notifyItemRangeChanged(position,manzaralar.size)

            }
            btnSil.setOnClickListener {
                manzaralar.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position,manzaralar.size)

            }
        }
    }
    override fun getItemCount(): Int {
        return manzaralar.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManzaraViwHolder {
        var inflater=LayoutInflater.from(parent.context)
        var tekSatirmanzara=inflater.inflate(R.layout.tek_satir_manzara,parent,false)
        return ManzaraViwHolder(tekSatirmanzara)

    }

    override fun onBindViewHolder(holder: ManzaraViwHolder, position: Int) {
        var oanOlusturulanManzara=manzaralar.get(position)
        holder.setData(oanOlusturulanManzara,position)

    }



}