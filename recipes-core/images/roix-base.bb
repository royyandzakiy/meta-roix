SUMMARY = "Roix base image for Raspberry Pi 4 — SSH + UART + eth0"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += " \
    ssh-server-openssh \
    debug-tweaks \
"

IMAGE_INSTALL:append = " \
    kernel-modules \
    i2c-tools \
    net-tools \
    iproute2 \
    iputils \
    openssh-sshd \
    openssh-sftp-server \
    roix-netconf \
"

# Remove unused bloat
IMAGE_INSTALL:remove = "hicolor-icon-theme"