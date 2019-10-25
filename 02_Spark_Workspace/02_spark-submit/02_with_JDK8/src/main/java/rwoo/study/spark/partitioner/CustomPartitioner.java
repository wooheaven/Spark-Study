package rwoo.study.spark.partitioner;

import org.apache.spark.Partitioner;

public class CustomPartitioner extends Partitioner {

    private int numParts;

    public CustomPartitioner(int numParts) {
        this.numParts = numParts;
    }

    @Override
    public int numPartitions() {
        return numParts;
    }

    @Override
    public int getPartition(Object key) {
        int code = key.toString().hashCode() % this.numPartitions();
        if (code < 0) {
            return code + this.numPartitions();
        } else {
            return code;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CustomPartitioner) {
            CustomPartitioner pObj = (CustomPartitioner) obj;
            return pObj.numPartitions() == this.numPartitions();
        } else {
            return false;
        }
    }
}
