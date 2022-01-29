/*
Copyright 2020-2022 Alex Stockinger

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package com.dajudge.kindcontainer;

import org.junit.ClassRule;
import org.junit.Test;

public class Helm3Test {

    @ClassRule
    public static ApiServerContainer<?> K8S = new ApiServerContainer<>()
            .withHelm3(helm -> {
                helm.repo.add.run("mittwald", "https://helm.mittwald.de");
                helm.repo.update.run();
                helm.install
                        .namespace("kubernetes-replicator")
                        .createNamespace()
                        .run("kubernetes-replicator", "mittwald/kubernetes-replicator");
            });

    @Test
    public void can_install_something() {
    }
}
