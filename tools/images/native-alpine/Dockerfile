ARG BASE_IMAGE=base/alpine
ARG BASE_VERSION=""
ARG BASE_HASH="@sha256:c9f3323d2c363b8c87234a54a5f22810b8f921afbb88c21b20c86ff186972214"

FROM ghcr.io/elide-dev/base/alpine${BASE_VERSION}${BASE_HASH}

LABEL org.opencontainers.image.vendor=Elide
LABEL org.opencontainers.image.title="Elide Base (Native/Alpine)"
LABEL org.opencontainers.image.description="Base image for native Elide server apps on Alpine Linux"
LABEL org.opencontainers.image.version=v3-alpha1
LABEL org.opencontainers.image.url=https://github.com/elide-dev/elide
LABEL org.opencontainers.image.base.name=busybox:glibc${BASE_VERSION}${BASE_HASH}
LABEL org.opencontainers.image.source=https://github.com/elide-dev/elide/blob/v3/tools/images/native-alpine/Dockerfile

## GraalVM requires libstdc++
RUN apk --no-cache update && apk add libstdc++
