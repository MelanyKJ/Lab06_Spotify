package com.melany.lab06_spotify.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.melany.lab06_spotify.databinding.ItemListBinding
import com.melany.lab06_spotify.model.Music
class ListAdapter(private val dataSet: List<Music>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        var picture: ImageView =binding.pictureImage
        var cancion: TextView = binding.tvCancion
        var artista: TextView = binding.tvArtist
        var genero:TextView = binding.tvGender
        var estrella: ImageButton = binding.btnStar
        var play: ImageButton=binding.btnPlay
        var pause: ImageButton=binding.btnPause
        var wsp: ImageButton = binding.btnWsp
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(binding: ViewHolder, position: Int) {

        val music: Music = this.dataSet[position]
        val context = binding.itemView.context
        val idRes = context.resources.getIdentifier(music.picture, "drawable", context.packageName)

        binding.cancion.text = music.song
        binding.artista.text = music.artist
        binding.genero.text=music.gender
        binding.picture.setImageResource(idRes)

        binding.picture.setOnClickListener{
            Toast.makeText(context,"Cancion: ${music.song}",Toast.LENGTH_SHORT).show()
        }
        //OnClickListener --> BOTON PLAY
        binding.play.setOnClickListener {
            Toast.makeText(context,"Canción: ${music.song} Artista: ${music.artist}",Toast.LENGTH_SHORT).show() }
        //OnClickListener --> BOTON PAUSE
        binding.pause.setOnClickListener {
            Toast.makeText(context,"Canción: ${music.song} Artista: ${music.artist}",Toast.LENGTH_SHORT).show() }
        //OnClickListener  --> BOTON WSP
        binding.wsp.setOnClickListener {
            try{
                val numero = "+51941120769"
                val text1 = "Hola" + "\uD83D\uDE4B\u200D♀, te comparto esta cancion: ${music.song} " +
                        "artista: ${music.artist} y su genero: ${music.gender}!!!"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$numero&text=$text1")
                context.startActivity(intent)
            }catch (e: Exception){
                e.printStackTrace()
            } }
        if (music.gender=="Rock"){ binding.estrella.visibility= View.VISIBLE }
    }
    override fun getItemCount(): Int = dataSet.size
}
