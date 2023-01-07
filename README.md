# Perlin-Noise-Java-Simplified
A short version of perlin noise in java, this is for 2D and lower(for lower just enter 0 for y)

The perlin noise algorithm developed by Ken Perlin mimics real life like smooth generation, allowed natural
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

Whatever you do, do not change the format of the code to static, I attempted it and for whatever reason
it resulted in the unexpected breakdown of the algorithm and becomes repetitive kinda like a sine wave,
i spent too long trying to figure out what was wrong, do not do the same

If you want more extreme terrain alongside the perlin noise generation check my repositaries, there should be one
