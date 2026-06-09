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
"

# Remove unused bloat
IMAGE_INSTALL:remove = "hicolor-icon-theme"

hostname:pn-base-files = "roixpi"

ROOTFS_POSTPROCESS_COMMAND += "setup_eth0_dhcp;"

setup_eth0_dhcp() {
    install -d ${IMAGE_ROOTFS}/etc/systemd/network
    cat > ${IMAGE_ROOTFS}/etc/systemd/network/20-eth0.network << EOF
[Match]
Name=eth0

[Network]
DHCP=yes
IPv6AcceptRA=yes
EOF
}