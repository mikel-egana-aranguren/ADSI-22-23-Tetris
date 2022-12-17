package com.zetcode;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio 
{
	private static Audio miAudio=null;
	
	private Audio() {}
	
	public static Audio getAudio()
	{
		if(miAudio==null)
		{
			miAudio=new Audio();
		}
		return miAudio;
	}
	
	//METODOS
	public void Musica()
	{
		if(Personalizar.getPersonalizar().getMusica())
		{
			try {
		        Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(Audio.class.getResourceAsStream("tetris.wav"));
		        clip.open(inputStream);
		        clip.start(); 
		      } 
			catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		}
	}
}
