package com.flipkart.foxtrot.client.cluster;

import com.flipkart.foxtrot.client.FoxtrotClientConfig;
import com.flipkart.foxtrot.client.selectors.EndpointType;
import com.flipkart.foxtrot.client.selectors.RandomSelector;

public class FoxtrotClusterFactory {

    private final FoxtrotClientConfig clientConfig;

    public IFoxtrotCluster getCluster(EndpointType endpointType) throws Exception {
        switch (endpointType) {
            case SIMPLE:
                return new FoxtrotSimpleCluster(clientConfig);
            case DISCOVERY:
                return new FoxtrotNodeDiscoveryCluster(clientConfig, new RandomSelector());
            default:
                throw new UnsupportedOperationException("Endpoint type: " + endpointType + " not supported");
        }
    }


    public FoxtrotClusterFactory(final FoxtrotClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }
}
