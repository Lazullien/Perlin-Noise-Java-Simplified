# Perlin-Noise-Java-Simplified
A short version of perlin noise in java, this is for 2D and lower(for lower just enter 0 for y)

The perlin noise algorithm developed by Ken Perlin mimics real life like smooth generation, allowing natural
mountains and oceans to be completely pseudorandom, it is mostly used to generate terrain, as well as other values
to define regions or biomes of a game, it is also widely used in computer animation for realistic and low budget
effects

To use, simply instantiate the class somewhere else and enter the parameters for the method either octaveNoise
or perlinNoise, octaveNoise you can have more control over being able to set octave and persistance,
but perlinNoise method is just as usable

for the SavedValues.seed bit, simply change it to a long type number
and remove import world.SavedValues
if you're wondering why you need a permulation table instead of actually random numbers it's to achieve the pseudorandom
effect, the array is shuffled based on seed allowing easy seed based generation

the code defaultly doesn't work in static because of the constructor needed for assigning an array, you could make it work
if you decide to put the permulation scrambling elsewhere though(and if you do so please change the methods to static)

If you want more extreme terrain alongside the perlin noise generation check my repositories, there should be one
