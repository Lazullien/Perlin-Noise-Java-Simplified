package calculate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import world.SavedValues;

public class Perlin{
	
      public double perlinNoise(double x, double y) {
          int X = (int)Math.floor(x) & 255,               
              Y = (int)Math.floor(y) & 255;                
          x -= Math.floor(x);                             
          y -= Math.floor(y);
          double u = fade(x),                           
                 v = fade(y);
          int rn= p[p[X]+Y], rn2= p[p[X+1]+Y], rn3=p[p[X]+Y+1], rn4= p[p[X+1]+Y+1];                   //4 random gradients at square corners
          return lerp(v, lerp(u, grad(rn, x, y),                 
        		                 grad(rn2, x-1, y)),
        		         lerp(u, grad(rn3, x, y-1),
        		        		 grad(rn4, x-1, y-1)));
      }      
      
      double lerp(double a, double le, double ri) {
		            return le*(1-a)+a*ri;}
      
      double grad(int hash, double x, double y) {
      	  switch(hash & 3){
       	  case 0: return x + y;
      	  case 1: return -x + y;
      	  case 2: return x - y;
      	  case 3: return -x - y;
      	  default: return 0;}
      }
      
      double fade(double y) {return y*y*y*(y*(y*6-15)+10);}
      
      public double octaveNoise(double x, double y, double octave, double persistence) {
    	  double total=0;
    	  double frequency= 2;
    	  double amplitude= 1;
    	  double max= -1.5;
    	  for(int o=0; o<octave; o++) {                                                                    //put things i'm never gonna interact with here cause why not
    		  total += perlinNoise(x*frequency, y*frequency)*amplitude;
    		  max += amplitude;
      		  amplitude *= persistence;
    		  frequency*=2;
    	  }
    	  return total/max;
      }
      
	  final int p[] = new int[512], 
			   defa[] = { 151,160,137,91,90,15,                                                 //random numbers 1~255
			   131,13,201,95,96,53,194,233,7,225,140,36,103,30,69,142,8,99,37,240,21,10,23,
			   190, 6,148,247,120,234,75,0,26,197,62,94,252,219,203,117,35,11,32,57,177,33,
			   88,237,149,56,87,174,20,125,136,171,168, 68,175,74,165,71,134,139,48,27,166,
			   77,146,158,231,83,111,229,122,60,211,133,230,220,105,92,41,55,46,245,40,244,
			   102,143,54, 65,25,63,161, 1,216,80,73,209,76,132,187,208, 89,18,169,200,196,
			   135,130,116,188,159,86,164,100,109,198,173,186, 3,64,52,217,226,250,124,123,
			   5,202,38,147,118,126,255,82,85,212,207,206,59,227,47,16,58,17,182,189,28,42,
			   223,183,170,213,119,248,152, 2,44,154,163, 70,221,153,101,155,167, 43,172,9,
			   129,22,39,253, 19,98,108,110,79,113,224,232,178,185, 112,104,218,246,97,228,         //rnpermu
			   251,34,242,193,238,210,144,12,191,179,162,241, 81,51,145,235,249,14,239,107,
			   49,192,214, 31,181,199,106,157,184, 84,204,176,115,121,50,45,127, 4,150,254,
			   138,236,205,93,222,114,67,29,24,72,243,141,128,195,78,66,215,61,156,180
			   };
	   
	   int[] arrange(long seed, int[] array) {
		   Integer[] intarray= Arrays.stream( array ).boxed().toArray( Integer[]::new );;
		   List<Integer> intList = Arrays.asList(intarray);
		   Collections.shuffle(intList, new Random(seed));
		   return intList.stream().mapToInt(Integer::intValue).toArray();
	   }
	  
	   int[] rnpermu = arrange(SavedValues.seed, defa);
	   { for(int i=0; i < 256; i++) p[256+i]= p[i]= rnpermu[i]; }
      
}
	
		
	
	
