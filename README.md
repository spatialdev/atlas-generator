# atlas-generator

A simple program to convert Atlas files.  
This program uses [Atlas](https://github.com/osmlab/atlas)'s built in converters. 

## Generate from PBF

The generate task will convert an OSM PBF into an atlas file. 

### Usage

The program uses Gradle, and operates using the task `generate`.  

It takes three arguments:  
`-Pinput`: input file path  
`-Poutput`: output file path
`-Piso`: iso code to assign to all the features

`./gradlew generate -Pinput=inputFilePath -Poutput=outputFilePath -Piso=isoAlpha3Code`

If running from a location other than the root of this program use `-p` to define the root.  
Relative paths of `inputFilePath` and `outputFilePath` are always from the project root.  

### Python Example

A simple python script to loop through a directory of PBF's and convert them to Atlas files.  
This script is set to run from a sibling level directory to atlas-generator, named atlas-generator_py_test.

```python
import os

for file in os.listdir("pbfs"):
	os.system("../atlas-generator/gradlew generate -p ../atlas-generator -Pinput=../atlas-generator_py_test/pbfs/{0} -Poutput=../atlas-generator_py_test/atlas/{1}.atlas -Piso=UNK".format(file,file.split('.')[0]))
```

## De-shard an Atlas

The deshard task can be used to convert a directory of atlas shards into a single atlas.

### Usage

The program uses Gradle, and operates using the task `deshard`.  

It takes two arguments:  
`-Pinput`: input directory path  
`-Poutput`: output file path

`./gradlew deshard -Pinput=inputDirPath -Poutput=outputFilePath`

If running from a location other than the root of this program use `-p` to define the root.  
Relative paths of `inputDirPath` and `outputFilePath` are always from the project root. 

## Size Constraint

This program suffers from the same size constraints as all implementations of Atlas.  
You will only be able to run files that can be processed in your machines memory.  
This is the same as AtlasChecks.