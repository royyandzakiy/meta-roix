SUMMARY = "systemd-networkd configuration for roix (eth0 DHCP)"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://20-eth0.network"

# Plain config, no compiled code -> architecture independent.
inherit allarch

# The .network file is only meaningful with systemd-networkd.
RDEPENDS:${PN} = "systemd"

do_install() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/20-eth0.network \
        ${D}${sysconfdir}/systemd/network/20-eth0.network
}

FILES:${PN} = "${sysconfdir}/systemd/network/20-eth0.network"
