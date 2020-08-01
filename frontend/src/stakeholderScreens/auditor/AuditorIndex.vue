<template>
  <div>
    <AppBar />
    <SideBar :navItems="auditorNavItems" />
    <v-main app>
      <v-container>
        <router-view></router-view>
      </v-container>
    </v-main>

    <Footer />
  </div>
</template>

<script>
import SideBar from "@/dashboard/layout/SideBar.vue";
import AppBar from "@/dashboard/layout/AppBar.vue";
import Footer from "@/dashboard/layout/Footer.vue";

export default {
  name: "AuditorIndex",
  methods: {
    changeMiniVariant() {
      this.miniVariant = !this.miniVariant;
    },
  },
  components: {
    SideBar,
    AppBar,
    Footer,
  },
  data() {
    return {
      miniVariant: true,
      auditorNavItems: [
        {
          title: "Audit Evidence Report",
          icon: "",
          route: { name: "AuditEvidenceReport" },
        },
        {
          title: "Evidence Inquiries",
          icon: "",
          route: { name: "EvidenceInquiries" },
        },
        {
          title: "Evidence Fraud Report",
          icon: "",
          route: { name: "EvidenceFraudReport" },
        },
        {
          title: "Back To Stakeholders Dashboard",
          icon: "fa-home",
          route: "/dashboard",
        },
      ],
    };
  },
};
</script>

<style lang="scss" scoped></style>

