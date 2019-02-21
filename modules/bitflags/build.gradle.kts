/*
 * Copyright (c) 2018. Louis Cognault Ayeva Derman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    kotlin("multiplatform")
    `maven-publish`
    id("com.jfrog.bintray")
}

enablePublication()

kotlin {
    metadataPublication(project)
    jvmWithPublication(project)
    jsWithPublication(project)
    sourceSets {
        getByName("commonMain").dependencies {
            api(kotlin("stdlib-common"))
        }
        getByName("jvmMain").dependencies {
            api(kotlin("stdlib-jdk7"))
        }
        getByName("jsMain").dependencies {
            api(kotlin("stdlib-js"))
        }
    }
}

publishing {
    setupAllPublications(project)
}

bintray {
    setupPublicationsUpload(project, publishing)
}