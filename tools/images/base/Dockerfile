ARG UBUNTU_VERSION=22.04
ARG UBUNTU_HASH="@sha256:b060fffe8e1561c9c3e6dea6db487b900100fc26830b9ea2ec966c151ab4c020"

FROM ubuntu:${UBUNTU_VERSION}${UBUNTU_HASH}

LABEL org.opencontainers.image.vendor=Elide
LABEL org.opencontainers.image.title="Elide Base"
LABEL org.opencontainers.image.description="Base image for Elide apps and tools"
LABEL org.opencontainers.image.version=v3-alpha1
LABEL org.opencontainers.image.url=https://github.com/elide-dev/elide
LABEL org.opencontainers.image.base.name=ubuntu:${UBUNTU_VERSION}
LABEL org.opencontainers.image.source=https://github.com/elide-dev/elide/blob/v3/tools/images/base/Dockerfile

RUN apt-get update \
  && apt-get -y upgrade \
  && DEBIAN_FRONTEND=noninteractive apt-get -y install --no-install-recommends \
    libc6 \
    zlib1g \
  && apt-get remove perl \
  && apt-get autoremove \
  && rm -rf /var/lib/apt/lists/*

ENV LANG=en_US.UTF-8 \
  LANGUAGE=en_US \
  PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/lib/gvm/bin:/sbin:/bin
