package com.flipkart.foxtrot.client.cluster;

public interface IFoxtrotCluster {

    FoxtrotClusterMember member();

    void stop();

}
