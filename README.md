# Jenkins Docker Pipeline Assignment

## Overview

This pipeline:

1. Checks out the [hashicorp/http-echo](https://github.com/hashicorp/http-echo) repository.
2. Builds a Docker image using the repository's Dockerfile.
3. Pushes the image to Docker Hub.
4. Runs a container from the image and performs a health check.
5. Cleans up created containers and images.

## Structure

- **Jenkinsfile**: Defines the pipeline stages.
- **vars/dockerUtils.groovy**: Contains the `buildAndPushDockerImage` shared library function.
- **README.md**: This documentation.

## Prerequisites

- Jenkins configured with:
  - A Docker-enabled agent.
  - Credentials ID `dockerhub-credentials` containing Docker Hub username and password.
  - The Shared Library configured as `jenkins-shared-lib`.

## Usage

1. Commit the files to your repository.
2. Configure a Jenkins pipeline job pointing to this repo.
3. Run the pipeline to build, push, verify, and clean up the Docker image.


