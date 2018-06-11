# atlas-generator

A simple program to convert OSM PBF's to Atlas files.  
This program uses [Atlas](https://github.com/osmlab/atlas)'s built in converter. 

## Usage

The program uses Gradle, and operates using the task `generate`.  

It takes three arguments:  
`-Pinput`: input file path  
`-Poutput`: output file path
`-Piso`: iso code to assign to all the features

`./gradlew generate -Pinput=inputFilePath -Poutput=outputFilePath -Piso=isoAlpha3Code`

If running from a location other than the root of this program use `-p` to define the root.  
Relative paths of `inputFilePath` and `outputFilePath` are always from the project root.  

### Size Constraint

This program suffers from the same PBF size constraints as all implementations of Atlas.  
You will only be able to run files that can be processed in your machines memory.  
This is the same as AtlasChecks.

## Python Example

A simple python script to loop through a directory of PBF's and convert them to Atlas files.  
This script is set to run from a sibling level directory to atlas-generator, named atlas-generator_py_test.

```python
import os

for file in os.listdir("pbfs"):
	os.system("../atlas-generator/gradlew generate -p ../atlas-generator -Pinput=../atlas-generator_py_test/pbfs/{0} -Poutput=../atlas-generator_py_test/atlas/{1}.atlas -Piso=UNK".format(file,file.split('.')[0]))
```
