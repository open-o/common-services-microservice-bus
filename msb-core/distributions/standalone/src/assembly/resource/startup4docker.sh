#!/bin/sh
#
# Copyright (C) 2016 ZTE, Inc. and others. All rights reserved. (ZTE)
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#         http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
DIRNAME=`dirname $0`
RUNHOME=`cd $DIRNAME/; pwd`
echo @RUNHOME@ $RUNHOME

echo "### Starting redis...";
cd ./redis
./run.sh 
cd $RUNHOME

echo "\n\n### Starting openresty...";
cd ./openresty
./run.sh 
cd $RUNHOME

echo "\n\n### Starting apiroute..."
cd ./apiroute
./run.sh
