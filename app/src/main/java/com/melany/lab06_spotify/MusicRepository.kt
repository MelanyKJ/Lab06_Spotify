package com.melany.lab06_spotify

import com.melany.lab06_spotify.model.Music

class MusicRepository  (val music:MutableList<Music> = ArrayList()){

    init {
        getDataMusic()
    }

    private fun getDataMusic(): List<Music> {
        music.add(Music(100, "Woman", "Doja Cat", "Pop","img_1"))
        music.add(Music(200, "Words", "F.R. David", "Pop","img_2"))
        music.add(Music(300, "Indiana", "Hombres G", "Rock","img_3"))
        music.add(Music(400, "Yesterday", "The Beatles ", "Rock","img_4"))
        music.add(Music(500, "Yellow", "Coldplay", "Pop","img_5"))
        music.add(Music(600, "Tren al Sur", "Los prisioneros", "Rock","img_6"))
        music.add(Music(700, "locked away", "R. City", " Reggae fusion","img_7"))
        return music
    }
}

